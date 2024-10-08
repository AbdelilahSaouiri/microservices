package net.ensah.customerservice.dto.response;

import lombok.Builder;

@Builder
public record CustomerResponseDto(String customerId,String firstname,String lastName,String email) {
}
