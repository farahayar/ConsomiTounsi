package tn.esprit.pi.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuestionDAO {

	@JsonProperty("problem")
	private Problems problem;
	@JsonProperty("tags")
	private Set<Tags> tags;
	
	public QuestionDAO(){}

}
