package org.example.controller;
@RestController
@RequestMapping("/api")
public class OrderController {
        @GetMapping("/order-status")
        public String getExample() {
            return "This is an example response from the server.";
        }

        @PostMapping("/submit-order")
        public String postExample(@RequestBody String requestBody) {
            // Process the incoming request body
            return "Received the following request body: " + requestBody;
        }

}
