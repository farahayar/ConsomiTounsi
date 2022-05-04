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

import tn.esprit.pi.entities.User;
import tn.esprit.pi.entities.Bills;
import tn.esprit.pi.entities.ItemBills;
import tn.esprit.pi.entities.Products;
import tn.esprit.pi.services.IBillsService;
import tn.esprit.pi.services.UserService;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/bills")
@SessionAttributes("bills")
public class BillsController {

	@Autowired
	private IBillsService billsService;
	
	@Autowired
	private MessageSource messageSource;

	private final Logger log = LoggerFactory.getLogger(getClass());

	
	/* ----- View Bills[id] ----- */
	@GetMapping("/view/{id}")
	public String view(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash, Locale locale) {

		Bills bills = billsService.fetchBillsByIdWithUserWithBillsItemWithProduct(Long id);
		
		if (bills == null) {
			flash.addAttribute("error", messageSource.getMessage("text.facture.flash.db.error", null, locale));
			return "redirect:/list";
		}

		model.addAttribute("bills", bills);
		model.addAttribute("title", String.format(messageSource.getMessage("text.facture.vers.titulo", null, locale), bills.getDescription()));

		return "bills/view";
	}

	/* ----- Create Invoice for Client[id] ----- */
	@GetMapping("/form/{clientId}")
	public String create(@PathVariable(value = "Userid") Long Userid, Map<String, Object> model,
			RedirectAttributes flash, Locale locale) {

		User user = userService.retrieveUserById(Userid);
		
		if (user == null) {
			flash.addAttribute("error", messageSource.getMessage("text.cliente.flash.db.error", null, locale));
			return "redirect:/list";
		}

		Bills bills = new Bills();
		bills.setUser(user);

		model.put("invoice", bills);
		model.put("title", messageSource.getMessage("text.factura.form.titulo", null, locale));

		return "bills/form";
	}

	/* ----- Autocomplete for Finding Products (autocomplete-products.js)----- */
	@GetMapping(value = "/load-products/{term}", produces = { "application/json" })
	public @ResponseBody List<Products> loadProducts(@PathVariable String term) {
		return userService.findByName(term);
	}

	/* ----- Save Invoice ----- */
	@PostMapping("/form")
	public String save(@Valid Bills invoice, BindingResult result, Model model,
			@RequestParam(name = "item_id[]", required = false) Long[] itemId,
			@RequestParam(name = "amount[]", required = false) Integer[] amount, RedirectAttributes flash,
			SessionStatus status, Locale locale) {

		if (result.hasErrors()) {
			model.addAttribute("title", messageSource.getMessage("text.facture.form.titulo", null, locale));
			return "invoice/form";
		}

		if (itemId == null || itemId.length == 0) {
			model.addAttribute("title", messageSource.getMessage("text.factura.form.titulo", null, locale));
			model.addAttribute("error", messageSource.getMessage("text.factura.flash.lineas.error", null, locale));
			return "invoice/form";
		}

		for (int i = 0; i < itemId.length; i++) {
			Products product = billsService.findProductById(itemId[i]);

			ItemBills line = new ItemBills();
			line.setAmount(amount[i]);
			line.setProduct(product);
			invoice.addItemBills(line);

			log.info("ID: " + itemId[i].toString() + ", amount: " + amount[i].toString());
		}

		billsService.saveBills(bills);
		status.setComplete();

		flash.addFlashAttribute("success", messageSource.getMessage("text.factura.flash.crear.success", null, locale));

		return "redirect:/view/" + invoice.getClient().getId();
	}
	
	/* ----- Delete Invoice ----- */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, RedirectAttributes flash, Locale locale) {
		Bills bills = billsService.findBillsById(id);

		if (bills != null) {
			billsService.deleteBills(id);
			flash.addAttribute("success", messageSource.getMessage("text.factura.flash.eliminar.success", null, locale));
			return "redirect:/view/" + bills.getClient().getId();
		}

		flash.addFlashAttribute("error", messageSource.getMessage("text.factura.flash.db.error", null, locale));
		return "redirect:/list/";
	}

}
