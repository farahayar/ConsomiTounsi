package tn.esprit.pi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import tn.esprit.pi.entities.ItemBills;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "bills")

public class Bills implements Serializable {
	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String description;
		
		private String observation;

		@Temporal(TemporalType.DATE)
		@Column(name = "create_at")
		private Date createAt;

		@ManyToOne(fetch = FetchType.LAZY)
		@JsonBackReference
		private User user;

		@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
		@JoinColumn(name = "bills_id")
		private List<ItemBills> items;

		@PrePersist
		public void prePersist() {
			createAt = new Date();
		}
		
		public Bills() {
			this.items = new ArrayList<ItemBills>();
		}
		
		public Double getTotal() {
			Double total = 0.0;		
			int size = items.size();
			
			for(int i = 0; i < size; i++) {
				total += items.get(i).calculateImport();
			}

			return total;
		}
}
