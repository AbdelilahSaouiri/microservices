package net.ensah.customerservice.dto.request;

import lombok.Builder;

@Builder
public record CustomerRequestDto(String firstName, String lastName, String email) {
}
