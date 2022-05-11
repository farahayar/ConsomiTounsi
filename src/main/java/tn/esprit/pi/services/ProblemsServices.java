package tn.esprit.pi.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import io.swagger.annotations.Info;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.pi.entities.Comments;
import tn.esprit.pi.entities.Problems;
import tn.esprit.pi.entities.Tags;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.repository.ProblemsRepository;
import tn.esprit.pi.repository.TagsRepository;
import tn.esprit.pi.repository.UserRepository;

@Service
@Slf4j
public class ProblemsServices implements IProblemsServices {

	@Autowired
	ProblemsRepository problemsRepository;

	@Autowired
	UserRepository userRepository;
	@Autowired
	TagsRepository tagsRepository;

	@Override
	public List<Problems> retrieveAll() {

		return (List<Problems>) problemsRepository.findAll();
	}

	@Override
	public Problems retrieveById(Long id) {
		return (Problems) problemsRepository.findById(id).get();
	}

	@Override
	public addProblemResponse save(Problems p, Set<Tags> tags, Long idUser) {
		User u = (User) userRepository.findById(idUser).get();
		Problems pB = p;
		Boolean b = false;
		if (u == null) {
			return null;
		}

		List<Problems> probs = (List<Problems>) problemsRepository.findAll();
		for (Problems problems : probs) {
			double dis = this.similarity(p.getTitle(), problems.getTitle());
			// log.info("similarité: ", dis);

			if (dis > 0.9) {
				pB = problems;
				b = true;
				break;
			}

		}
		if (b) {
			return new addProblemResponse(pB, true);

		} else if (!containsBadWords(p.getTitle()) && !containsBadWords(p.getSubject())) {
			Set<Tags> tagsToAdd = new HashSet<Tags>();
			Set<Problems> ps = u.getProblems();
			tags.forEach(tag -> {
				Tags t = tagsRepository.findByTagLike(tag.getTag());
				if (t == null) {
					tagsToAdd.add(tagsRepository.save(tag));
				} else {
					tagsToAdd.add(t);
				}

			});
			p.setUser(u);
			p.setTags(tagsToAdd);
			p.setDate(new Date());
			ps.add(p);
			return new addProblemResponse((Problems) problemsRepository.save(p), false);
		}
		return null;
	}

	@Override
	public Problems update(Problems p) {
		return (Problems) problemsRepository.save(p);
	}

	// Todo
	@Override
	public void delete(Long id) {
		problemsRepository.deleteById(id);

	}

	public static boolean containsBadWords(String body) {
		ClassPathResource res = new ClassPathResource("/src/main/resources/badWords.txt");
		File file = new File(res.getPath());
		// File file = new File("/src/main/resources/badWords.txt");
		List<String> bodyList = Arrays.asList(body.toLowerCase().split(" "));

		try {
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (bodyList.contains(line)) {
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static double similarity(String s1, String s2) {
		log.info("method simi in");

		String longer = s1, shorter = s2;
		if (s1.length() < s2.length()) { // longer should always have greater
											// length
			longer = s2;
			shorter = s1;
		}
		int longerLength = longer.length();
		if (longerLength == 0) {
			return 1.0;
			/* both strings are zero length */ }
		return (longerLength - editDistance(longer, shorter)) / (double) longerLength;
	}

	public static int editDistance(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		int[] costs = new int[s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			int lastValue = i;
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0)
					costs[j] = j;
				else {
					if (j > 0) {
						int newValue = costs[j - 1];
						if (s1.charAt(i - 1) != s2.charAt(j - 1))
							newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
						costs[j - 1] = lastValue;
						lastValue = newValue;
					}
				}
			}
			if (i > 0)
				costs[s2.length()] = lastValue;
		}
		return costs[s2.length()];
	}

	@Override
	public Problems closeProblem(Long id) {
		Problems p = problemsRepository.findById(id).orElse(null);
		p.setClosed(true);
		return (Problems) problemsRepository.save(p);

	}

	@Scheduled(cron = "0 0 0 * * 1,4")
	public void deleteProblemWithoutInter() {

		List<Problems> ps = problemsRepository.findByClosed(false);
		for (Problems problems : ps) {
			if (problems.comments.isEmpty() && problems.Approveds.isEmpty()) {
				problemsRepository.delete(problems);
			}

		}
	}

	@Override
	public List<Problems> recently() {
		// get current date
		Date currentDate = Calendar.getInstance().getTime();
		// get current date minus 1 year
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONDAY, -1);
		Date startDate = c.getTime();
		return problemsRepository.findByDateBetween(startDate,currentDate);
	}
}
