package org.example.controller;
@RestController
@RequestMapping("/v1")
public class OrderController {
        @GetMapping("/order-status")
        public String getStatus() {
            return "This is an example response from the server.";
        }
        @PostMapping("/submit-order")
        public String submitOrder(@RequestBody String requestBody) {
            // Process the incoming request body
            return "Received the following request body: " + requestBody;
        }
        @GetMapping("/order-availability-Status")
        public String getAviability() {
            return "This is an example response from the server.";
        }

}
