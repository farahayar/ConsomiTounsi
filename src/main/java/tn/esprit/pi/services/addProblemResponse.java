package tn.esprit.pi.services;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.pi.entities.Problems;
import tn.esprit.pi.entities.Tags;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class addProblemResponse {
	@JsonProperty("problem")
	private Problems problem;
	private boolean existes;
	

}
