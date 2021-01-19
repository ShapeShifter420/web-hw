package org.ShapeShifter420.webapp;

import jakarta.validation.Valid;
import org.ShapeShifter420.webapp.DB.DataBase;
import org.ShapeShifter420.webapp.DB.models.Tables;
import org.ShapeShifter420.webapp.mailsender.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;


@Controller
public class HelloController {
    public MailSender m = new MailSender();
    @GetMapping("/")
    public String sayHello() {
        return "index.html";
    }
    @GetMapping("/about")
    public String getAbout() {
        return "about.html";
    }
    @GetMapping("/menu")
    public String getMenu() {
        return "menu.html"; }
    //@GetMapping("/bron")
    public String getBron() {
        return "bron";
    }

    //@RequestMapping(value="/bron", method= RequestMethod.GET)
   // public String greetingForm(Model model) {
   //     model.addAttribute("bron", new BronModel());
    //    return "bron.html";
    //}

    //@RequestMapping(value="/bron", method=RequestMethod.POST)
    //public String greetingSubmit(@ModelAttribute BronModel bron, Model model) {
    //    model.addAttribute("bron", bron);
    //    return "about.html";
    //}
    @RequestMapping(value="/tables", method= RequestMethod.GET)
    public String greetingFormT(Model model) {
        model.addAttribute("bron", new BronModel());
        model.addAttribute("tables", DataBase.getAllTables().toArray());
        System.out.println(Arrays.toString(DataBase.getAllTables().toArray()));
        return "tablesp.html";
    }

    @RequestMapping(value="/tables", method=RequestMethod.POST)
    public String greetingSubmitT(@ModelAttribute BronModel bron, Model model) throws IOException {
        if (DataBase.checkAllready(bron.getTable()))
        {
            System.out.println("xeno");
            System.out.println(bron.getTable());
            BronModel newbron = new BronModel();
            newbron.error = true;
            model.addAttribute("bron", newbron);
            model.addAttribute("tables", DataBase.getAllTables().toArray());
            return "tablesp.html";}
        else{
            Tables tabel = new Tables(bron.getTable(), bron.getEmail(),true,bron.getTime_begin());
            DataBase.update(tabel);
        model.addAttribute("bron", bron);

            try {
                m.send("Бронирование стола","Ваш регистрационный код: "+tabel.getReg_number(),bron.getEmail());
            } catch (Exception e) {
                e.printStackTrace();
            }
        return "redirect:/about.html";}
    }

    @GetMapping("/anotations")
    public String getanotations() {
        return "anotations.html";
    }
}
