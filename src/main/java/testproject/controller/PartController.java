package testproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testproject.model.Part;
import testproject.service.PartService;


import javax.annotation.Resource;


@Controller
public class PartController {

    private int page;
    private String par = "all", search = "";


    private PartService partService;
    @Autowired
    public void setPartService(PartService partService) {
        this.partService = partService;
    }




    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView listParts(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "all") String par,
                                  @RequestParam(defaultValue = "") String search){
        this.page = page;
        this.search = search;
        this.par = par;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("partDetails");
        int partsAmount = partService.getPartsAmount(par, search);
        modelAndView.addObject("pages", (partsAmount+9)/10);
        modelAndView.addObject("page", page);
        modelAndView.addObject("listParts", partService.getList(page, par, search));
        modelAndView.addObject("partsAmount", partsAmount);
        modelAndView.addObject("search", search);
        modelAndView.addObject("par", par);
        modelAndView.addObject("complect", partService.getComplect());
        return modelAndView;
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        partService.removePart(id);
        return "redirect:/?page=" + this.page + "&par=" + par;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Part part = partService.getPartById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("part", part);

        return modelAndView;
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editPart(@ModelAttribute("part") Part part) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/?page=" + this.page + "&par=" + par);
        partService.updatePart(part);
        return modelAndView;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add");
        return modelAndView;
}

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addPart(@ModelAttribute("part") Part part) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/?page=" + this.page + "&par=" + par);
        partService.addPart(part);
        return modelAndView;
    }



}