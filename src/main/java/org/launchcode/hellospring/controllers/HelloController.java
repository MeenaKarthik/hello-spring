package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm(){
        return  "<html>" +
                "<body>" +
                "<form action = 'greet' method = 'post'>" +//submit a request to /hello/greet
                "<input type= 'text' name= 'name'>" +
                "<select name = 'language' id = 'language'>"+
                "<option value = 'Hindi'>Hindi</option>"+
                "<option value = 'French'>French</option>"+
                "<option value = 'English' selected>English</option>"+
                "<option value = 'Tamil'>Tamil</option>"+
                "<option value = 'Malayalam'>Malayalam</option>"+
                "</select>"+
                "<input type = 'submit' value='Greet me'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(method = {RequestMethod.POST}, value = "greet")
    public String postMessage(@RequestParam String name, @RequestParam String language){
        if(name.equals("")){
            name = "Guest";
        }
    return createMessage(name,language);
    }

    public static String createMessage(String name, String language){

        String greeting = "";
        if(language.equals("English"))
            greeting = "Hello";
        else if(language.equals("Tamil"))
            greeting = "Vanakkam";
        else if(language.equals("Hindi"))
            greeting = "Namaste";
        else if(language.equals("French"))
            greeting = "Bonjour";
        else if(language.equals("Malayalam"))
            greeting = "halayaa";
        return  "<html>" +
                "<body>"+
                "<h2><i>"+greeting+" "+name+"!</i></h2>"+
                "</body>"+
                "</html>";
    }

}
