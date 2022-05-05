package tn.esprit.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pi.entities.DeliveryPerson;
import tn.esprit.pi.services.IDeliveryPersonService;

@RestController
@RequestMapping("/DeliveryPerson")
class DeliveryPersonController {

    @Autowired
    IDeliveryPersonService deliveryPersonService;

  
  @GetMapping("/showDeliveryPerson")
	@ResponseBody 
	List<DeliveryPerson> showAllDeliveryPerson(){
	return deliveryPersonService.retrieveAll();
	}
	
	
	@GetMapping("/showDeliveryPerson/{id}")
	@ResponseBody 
	DeliveryPerson showDeliveryPerson(@PathVariable("idDeliveryPerson")Long id) {
	return deliveryPersonService.retrieveById(id);
	}

    @PostMapping("/adddeliveryPerson")
    @ResponseBody
    public DeliveryPerson addDeliveryPerson(@RequestBody DeliveryPerson dl) {
		return deliveryPersonService.addDeliveryPerson(dl);
    }

	@PutMapping("/updatedeliveryPerson")
	@ResponseBody
	DeliveryPerson updateStock(@RequestBody DeliveryPerson dp) { 
	return deliveryPersonService.updateDeliveryPerson(dp);
	}
	
	@DeleteMapping("/deletedeliveryPerson/{id}")
	@ResponseBody
	void supprimerDeliveryPerson(@PathVariable("id") Long id_deliveryp) {
	deliveryPersonService.deleteDeliveryPerson(id_deliveryp);
    }

}

