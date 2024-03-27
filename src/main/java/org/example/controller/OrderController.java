package org.example.controller;

@Tag(name = "order-management")
@RestController
@RequestMapping("/v1")
public class OrderController {

    @Autowired
    private OrderService orderService; // Inject your service layer

    @GetMapping("/order-status")
    @SecurityClassification(dataConfidentiality = DataConfidentiality.C4, dataCompliance = @DataCompliance(ComplianceFlag.RDPP))
    public StatusResponse getOrderStatus(
            @Parameter @PathVariable(name = "orderId") final OrderIdSanitization orderId,
            @Parameter @RequestParam(name = "customerId") final CustomerIdSanitization customerId)
            @Parameter @RequestParam(name = "productName" , required = true) final ProductNameSanitizer productName) {
        // Retrieve order status logic
        return orderService.getOrderStatus(orderId, customerId,productName);
    }

    @PostMapping("/submit-order")
    @SecurityClassification(dataConfidentiality = DataConfidentiality.C3, dataCompliance = @DataCompliance(ComplianceFlag.RDPP))
    public OrderResponse submitOrder(
            @RequestBody @Validated OrderRequest orderRequest,
            @Parameter @RequestParam(name = "customerId") final CustomerIdSanitization customerId) {
        // Process order submission logic
        return orderService.processOrder(orderRequest, customerId);
    }

    @GetMapping("/order-availability")
    @SecurityClassification(dataConfidentiality = DataConfidentiality.C3, dataCompliance = @DataCompliance(ComplianceFlag.RDPP))
    public OrderStatusResponse getOrderAvailability(
            @Parameter @PathVariable(name = "productId") final AgoIdSanitization productId,
            @Parameter @PathVariable(name = "usecase") final ValidationUseCaseSanitizer usecase,
            @Parameter @RequestParam(name = "scn") final ScnSanitization scn) {
        // Check product availability logic
        return orderService.checkProductAvailability(productId, usecase, scn);
    }
}
