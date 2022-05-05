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

import tn.esprit.pi.entities.Delivery;
import tn.esprit.pi.services.IDeliveryService;

@RestController
@RequestMapping("/Delivery")
class DeliveryController {

    @Autowired
    IDeliveryService deliveryService;

  
  @GetMapping("/showdelivery")
	@ResponseBody 
	List<Delivery> showAllDelivery(){
	return deliveryService.retrieveAll();
	}
	
	
	@GetMapping("/showdelivery/{id}")
	@ResponseBody 
	Delivery showDelivery(@PathVariable("idDelivery")Long id) {
	return deliveryService.retrieveById(id);
	}

    @PostMapping("/adddelivery")
    @ResponseBody
    public Delivery addDelivery(@RequestBody Delivery dl) {
		return deliveryService.addDelivery(dl);
	}

	@PutMapping("/updatedelivery")
	@ResponseBody
	Delivery updateStock(@RequestBody Delivery d) {
	return deliveryService.updateDelivery(d);
	}
	
	@DeleteMapping("/deletedelivery/{id}")
	@ResponseBody
	void supprimerDelivery(@PathVariable("id") Long id_delivery) {
	deliveryService.deleteDelivery(id_delivery);
    }

}

