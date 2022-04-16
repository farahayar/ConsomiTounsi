package tn.esprit.pi.entities;

<<<<<<< HEAD
public class ProductCategory {
=======
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class ProductCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idCategoryProd;
	int name_CategoryProd;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="productCategory")
	private Set<Products> products;
	
>>>>>>> cec7158ed91ee3d4ebae069aa02e395eadeb7340

}
