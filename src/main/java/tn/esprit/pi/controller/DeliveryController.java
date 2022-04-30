package tn.esprit.pi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pi.entities.Delivery;
import tn.esprit.pi.services.IDeliveryService;

@RestController
@RequestMapping("/resourceRootPath")
class resourceNameController {

    @Autowired
    IDeliveryService deliveryService;

  
  @GetMapping("/showDelivery")
	@ResponseBody 
	List<Delivery> showAllDelivery(){
	return deliveryService.retrieveAll();
	}
	
	
	@GetMapping("/showDelivery/{id}")
	@ResponseBody 
	Delivery showDelivery(@PathVariable("idDelivery")Long id) {
	return deliveryService.retrieveById(id);
	}

    @PostMapping("/add-delivery")
    @ResponseBody
    public Delivery addDelivery(@RequestBody Delivery dl) {
		return deliveryService.addDelivery(dl);
    }

}

