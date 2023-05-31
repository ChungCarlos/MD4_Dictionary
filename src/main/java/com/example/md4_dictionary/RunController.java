package com.example.md4_dictionary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RunController {

    private Map<String, String> dictionary;

    public RunController() {
        // Khởi tạo từ điển với một số từ và định nghĩa
        dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("world", "Thế giới");
        dictionary.put("spring", "Mùa xuân");
    }

    @GetMapping("/lookup")
    public String lookupWord(@RequestParam("word") String word, Model model) {
        String lowercaseWord = word.toLowerCase();
        String definition = dictionary.getOrDefault(lowercaseWord, "Không tìm thấy từ này trong từ điển");
        model.addAttribute("word", word);
        model.addAttribute("definition", definition);
        return "dictionary";
    }
}
