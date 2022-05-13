package tn.esprit.pi.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@EqualsAndHashCode
@Builder
public class Tags implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String tag;
	
	@JsonIgnore	
	@ManyToMany(fetch= FetchType.LAZY,mappedBy = "tags" ,cascade = CascadeType.ALL)
	public Set<Problems> problems;
	

}
