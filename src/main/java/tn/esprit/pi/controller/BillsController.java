package tn.esprit.pi.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import com.tn.esprit.gestionstock.Controller.Api;
import com.tn.esprit.gestionstock.Controller.ApiOperation;
import com.tn.esprit.gestionstock.Controller.CrossOrigin;
import com.tn.esprit.gestionstock.Controller.DeleteMapping;
import com.tn.esprit.gestionstock.Controller.PutMapping;
import com.tn.esprit.gestionstock.Controller.RequestBody;
import com.tn.esprit.gestionstock.Controller.RestController;
import tn.esprit.pi.controller.WebSocketController;
import tn.esprit.pi.entities.WebSocketMessage;

import tn.esprit.pi.entities.User;
import tn.esprit.pi.entities.Bills;
import tn.esprit.pi.entities.ItemBills;
import tn.esprit.pi.entities.Products;
import tn.esprit.pi.services.IBillsService;
import tn.esprit.pi.services.BillsService;
import tn.esprit.pi.services.UserService;

@RestController
@CrossOrigin("*")
@Api(tags = "Bill management")
@RequestMapping("/bill/")
public class BillsController  {

    @Autowired
    private BillsService billsService;
    @Autowired
    WebSocketController webSocketController;

    @ApiOperation(value = "Add bill ")
    @PostMapping("add")
    public Bills add(@Valid @RequestBody Bills bills) {
        Bills add = billsService.add(bills);
        webSocketController.sendMessage(new WebSocketMessage("add bill"+bills.getIdBill()));
        return add;
    }


    @ApiOperation(value = "Update bill ")
    @PutMapping("update/{id}")
    public Bills update(@Valid @RequestBody Bills bills,@PathVariable("id") Long id) {
    	Bills update = billsService.update(bills, id);
        webSocketController.sendMessage(new WebSocketMessage("update Bill"));
        return update;
    }

    @ApiOperation(value = "Delete bill")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        billsService.delete(id);
        webSocketController.sendMessage(new WebSocketMessage("delete Bill"));
    }

    @ApiOperation(value = "Retreive all bills")
    @GetMapping("list")
    public List<Bills> findAll() {
        return billsService.findAll();
    }

    @ApiOperation(value = "Find bill by provided id")
    @GetMapping("findById/{id}")
    public Bills findById(@PathVariable("id") Long id) {
        return billsService.findById(id);
    }
}
