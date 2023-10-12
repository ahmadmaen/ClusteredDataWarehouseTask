package ProgressSoft.example.ClusteredDataWarehouse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "fx_deal")
public class DealRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deal_unique_id", unique = true)
    @NotBlank(message = "Deal Unique Id is required")
    private String dealUniqueId;

    @Column(name = "ordering_currency_iso_code")
    @Pattern(regexp = "[A-Z]{3}", message = "Invalid Ordering Currency ISO Code")
    private String orderingCurrencyIsoCode;

    @Column(name = "to_currency_iso_code")
    @Pattern(regexp = "[A-Z]{3}", message = "Invalid To Currency ISO Code")
    private String toCurrencyIsoCode;

    @Column(name = "deal_timestamp")
    private LocalDateTime  dealTimestamp;

    @Column(name = "deal_amount")
    @DecimalMin(value = "0.0", inclusive = false, message = "Deal Amount must be greater than 0")
    private BigDecimal dealAmount;

    // Constructors :
    @PrePersist
    public void prePersist() {
        dealTimestamp = LocalDateTime.now();
    }

    public DealRequest() {
        // Default constructor
    }

    public DealRequest(String dealUniqueId, String orderingCurrencyIsoCode, String toCurrencyIsoCode,LocalDateTime dealTimestamp,  BigDecimal dealAmount) {
        this.dealUniqueId = dealUniqueId;
        this.orderingCurrencyIsoCode = orderingCurrencyIsoCode;
        this.toCurrencyIsoCode = toCurrencyIsoCode;
        this.dealTimestamp = dealTimestamp;
        this.dealAmount = dealAmount;
    }

    // Getter and Setter methods for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDealUniqueId() {
        return dealUniqueId;
    }

    public void setDealUniqueId(String dealUniqueId) {
        this.dealUniqueId = dealUniqueId;
    }

    public String getOrderingCurrencyIsoCode() {
        return orderingCurrencyIsoCode;
    }

    public void setOrderingCurrencyIsoCode(String orderingCurrencyIsoCode) {
        this.orderingCurrencyIsoCode = orderingCurrencyIsoCode;
    }

    public String getToCurrencyIsoCode() {
        return toCurrencyIsoCode;
    }

    public void setToCurrencyIsoCode(String toCurrencyIsoCode) {
        this.toCurrencyIsoCode = toCurrencyIsoCode;
    }

    public LocalDateTime  getDealTimestamp() {
        return dealTimestamp;
    }

    public void setDealTimestamp(LocalDateTime  dealTimestamp) {
        this.dealTimestamp = dealTimestamp;
    }

    public BigDecimal getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount) {
        this.dealAmount = dealAmount;
    }
}
