package br.com.gr.bodyshock.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gr.bodyshock.model.Relatorio;
import br.com.gr.bodyshock.service.ReportService;

@Controller
public class ReportController extends AbstractController {

	@Autowired
	private ReportService relatorioService;

	private static final String REPORT_PAGE = "relatorio/lista";

	@GetMapping(MAPPING_ADMIN + "relatorios")
	public ModelAndView relatorios() {
		List<Relatorio> relatorios = relatorioService.findAll();
		Collections.reverse(relatorios);
		return this.modelAndView(REPORT_PAGE).addObject("relatorios", relatorios);
	}

}
