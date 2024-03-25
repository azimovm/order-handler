package org.example.controller;

@Tag(name = "order-management")
@RestController
@RequestMapping("/v1")
public class OrderController {
        @GetMapping("/order-status")
        @SecurityClassification(dataConfidentiality = DataConfidentiality.C3, dataCompliance = @DataCompliance(ComplianceFlag.RDPP))
        public String getStatus() {
            return "This is an example response from the server.";
        }
        @PostMapping("/submit-order")
        @SecurityClassification(dataConfidentiality = DataConfidentiality.C3, dataCompliance = @DataCompliance(ComplianceFlag.RDPP))
        public String submitOrder(@RequestBody String requestBody) {
            return "Received the following request body: " + requestBody;
        }
        @GetMapping("/order-availability-Status")
        @SecurityClassification(dataConfidentiality = DataConfidentiality.C2, dataCompliance = @DataCompliance(ComplianceFlag.RDPP))
        public String getAviability() {
            return "This is an example response from the server.";
        }

}
