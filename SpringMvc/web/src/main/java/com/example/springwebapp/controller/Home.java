package com.example.springwebapp.controller;

import com.example.springwebapp.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class Home {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private checkRepository checkRepositor;
    @Autowired
    private BasketRepository basketRepository;

    private  int GetPrice(List<Product> products){
        Integer totalSum=0;
        for (int i=0;i<products.size();i++){
            Product product=products.get(i);
            totalSum=totalSum+product.getPrice();
        }
        return totalSum;
    }

    @RequestMapping("/")
    public String home(Model model1,HttpSession session) {
        List<Product> products13 = (List<Product>) session.getAttribute(session.getId());
        session.setAttribute(session.getId(), products13);
        model1.addAttribute("products", products13);
        model1.addAttribute("totatPrise", GetPrice(products13));
        return "basket";
    }


    @RequestMapping("/home-with-session")
    public String homeWithSession(Model model, HttpSession session, HttpServletRequest request) {
        String sid = session.getId();
        model.addAttribute("sid", sid);
        var cookies = request.getCookies();
        var filters_City = Arrays.stream(cookies)
                .filter(s -> "City".equals(s.getName()) && s.getValue() != null)
                .collect(Collectors.toList());
        List<Product> c = null;
        List<Product> p=(List<Product>)productRepository.findAll();
        if (filters_City.size() != 0) {
            c = p.stream()
                    .filter(s -> filters_City.get(0).getValue().equals(s.getCity()))
                    .collect(Collectors.toList());
            model.addAttribute("products", c);
        } else {
            model.addAttribute("products", p);
        }
        return "index";
    }


    @PostMapping(value = "/sortUser")
    public String sortBy(@RequestParam String sortP, Model model, HttpServletRequest request) {
        var cookies = request.getCookies();
        var filters_City = Arrays.stream(cookies)
                .filter(s -> "City".equals(s.getName()) && s.getValue() != null)
                .collect(Collectors.toList());
        List<Product> c = null;
        List<Product> p=(List<Product>)productRepository.findAll();
        if (sortP.contains("prise")) {
            if (filters_City.size() == 0) {
                c = p.stream()
                        .sorted(Comparator.comparing(Product::getPrice))
                        .collect(Collectors.toList());
            } else {
                c = p.stream()
                        .sorted(Comparator.comparing(Product::getPrice))
                        .filter(s -> filters_City.get(0).getValue().equals(s.getCity()))
                        .collect(Collectors.toList());
            }
        } else {
            if (filters_City.size() == 0) {
                c = p.stream()
                        .sorted(Comparator.comparing(Product::getManufacturer))
                        .collect(Collectors.toList());
            } else {
                c = p.stream()
                        .sorted(Comparator.comparing(Product::getManufacturer))
                        .filter(s -> filters_City.get(0).getValue().equals(s.getCity()))
                        .collect(Collectors.toList());
            }
        }
        model.addAttribute("products", c);
        return "cont";
    }

    @PostMapping(value = "/orderBy")
    public String filtrBy(@RequestParam String filtrP, Model model, HttpServletRequest request) {
        var cookies = request.getCookies();
        var filters_City = Arrays.stream(cookies)
                .filter(s -> "City".equals(s.getName()) && s.getValue() != null)
                .collect(Collectors.toList());
        List<Product> c = null;
        List<Product> p=(List<Product>)productRepository.findAll();
        if (filters_City.size() == 0) {
            c = p.stream()
                    .filter(s -> filtrP.equals(s.getManufacturer()))
                    .collect(Collectors.toList());
        } else {
            c = p.stream()
                    .filter(s -> filtrP.equals(s.getManufacturer()))
                    .filter(s -> filters_City.get(0).getValue().equals(s.getCity()))
                    .collect(Collectors.toList());
        }
        model.addAttribute("products", c);
        return "cont";
    }

    @PostMapping(value = "/add")
    public ResponseEntity addToCart(@RequestBody String form, HttpSession session) {
        var prodId = form.substring(form.indexOf(':') + 1);
        prodId = prodId.substring(prodId.indexOf('"') + 1, prodId.lastIndexOf('"'));
        var i = Integer.parseInt(prodId);
        List<Product> p=(List<Product>)productRepository.findAll();
        List<Product> products1 = (List<Product>) session.getAttribute(session.getId());
        if (products1 == null) {
            products1 = new ArrayList<>();
        }

        products1.addAll(p.stream()
                .filter(s -> i == s.getId())
                .collect(Collectors.toList()));

        session.setAttribute(session.getId(), products1);
        ObjectMapper objectMapper = new ObjectMapper();


        return new ResponseEntity(HttpStatus.OK);

    }

    @GetMapping(value = "/getCount")
    public @ResponseBody
    String getCounter(HttpSession session) {
        List<Product> products13 = (List<Product>) session.getAttribute(session.getId());
        Integer count = 0;
        if (products13 == null) {
            count = 1;
        } else {
            count = products13.size();
        }
        String str = count.toString();
        return str;
    }
    @GetMapping("/basket")
    public @ResponseBody
    String getBasket(HttpSession session) {
        List<Product> product = (List<Product>) session.getAttribute(session.getId());


        return "basket";
    }
    @RequestMapping(value = "/deletProductSession")
    public String deletProductSession(@RequestParam String idProduct, Model model, HttpSession session) {
        List<Product> products13 = (List<Product>) session.getAttribute(session.getId());
        Long id=Long.parseLong(idProduct);
        for(int i=0;i<products13.size();i++){
            Product product=products13.get(i);
            if(product.getId()==id) {
                products13.remove(product);
            }
        }
        session.setAttribute(session.getId(), products13);
        model.addAttribute("totatPrise", GetPrice(products13));
        model.addAttribute("products", products13);
        return "baketContainer";
    }
    @RequestMapping(value = "/cellProductSession")
    public String cellProductSession(Model model, HttpSession session,HttpServletRequest request) {
        var cookies = request.getCookies();
        var filters_City = Arrays.stream(cookies)
                .filter(s -> "City".equals(s.getName()) && s.getValue() != null)
                .collect(Collectors.toList());
        List<Product> products13 = (List<Product>) session.getAttribute(session.getId());
        Date date=new Date();
        checkEdUser checkEdUser=new checkEdUser(filters_City.get(0).getValue(),date);
        checkRepositor.save(checkEdUser);
        Long id=checkRepositor.findMax();
        for(int i=0;i<products13.size();i++){
           Product product=products13.get(i);
           Basket baske=new Basket(id,product.getId());
           basketRepository.save(baske);
        }
        products13=new ArrayList<Product>();
        session.setAttribute(session.getId(), products13);
        model.addAttribute("products", products13);
        model.addAttribute("totatPrise", 0);
        return "baketContainer";
    }

}

