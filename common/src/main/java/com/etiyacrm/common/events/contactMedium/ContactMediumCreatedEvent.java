package com.etiyacrm.common.events.contactMedium;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactMediumCreatedEvent {
    private String id;
    private String mobilePhone;
    private String homePhone;
    private String email;
    private String fax;
    private String customerId;
}
