package com.etiyacrm.customerservice.services.messages;

public class Messages {
    public static class BusinessErrors{
        public static class AddressErrors{
            public static final String AddressNotFound = "addressNotFound";
        }
        public static class BillingAccountErrors{
            public static final String BillingAccountNotFound = "billingAccountNotFound";
        }
        public static class CityErrors{
            public static final String CityNameExists ="cityNameExists";
            public static final String CityNotFound = "cityNotFound";
        }
        public static class ContactMediumErrors{
            public static final String ContactMediumNotFound = "contactMediumNotFound";
        }
        public static class CustomerErrors{
            public static final String CustomerNotFound = "customerNotFound";
        }
        public static class IndividualCustomerErrors{
            public static final String IndividualCustomerNotFound = "individualCustomerNotFound";
            public static final String CheckIfPersonExistsInMernisDB = "checkIfPersonExistsInMernisDB";
            public static final String CheckAgeVerification = "checkAgeVerification";

        }
    }
}