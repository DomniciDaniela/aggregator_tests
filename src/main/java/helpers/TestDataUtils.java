package helpers;

import helpers.utility.ConfigLoad;

public class TestDataUtils {

    public static class Aggregators {
        public static final String ESURE = "https://etst" + ConfigLoad.ConfigLoadVariables.WEB_APP_ENVIRONMENT + ".es-dte.co.uk/testlink.jsp";
        public static final String FA = "https://ftst" + ConfigLoad.ConfigLoadVariables.WEB_APP_ENVIRONMENT + ".es-dte.co.uk/testlink.jsp";
        public static final String SW = "https://ltst"  + ConfigLoad.ConfigLoadVariables.WEB_APP_ENVIRONMENT + ".es-dte.co.uk/testlink.jsp";

        public static final String ESURE_DEV = "https://edev" + ConfigLoad.ConfigLoadVariables.WEB_DEV_ENVIRONMENT + ".es-dte.co.uk/testlink.jsp";
        public static final String FA_DEV = "https://fdev" + ConfigLoad.ConfigLoadVariables.WEB_DEV_ENVIRONMENT + ".es-dte.co.uk/testlink.jsp";
        public static final String SW_DEV = "https://ldev"  + ConfigLoad.ConfigLoadVariables.WEB_DEV_ENVIRONMENT + ".es-dte.co.uk/testlink.jsp";
    }

    public static class AuthorizationCredentials {
        public static final String BASIC_AUTHORIZATION = "Basic ZXN1cmVfdXNlcjplNXVyZV91NWVy";
    }

    public static class Brands {
        public static final String ESURE_HOME = "EH";
        public static final String ESURE_MOTOR = "EM";
        public static final String SW_MOTOR= "SW";
    }

    public static class Flags {
        public static final String YES = "Y";
    }

    public static class Other {
        public static final String OTHER = "Other";
        public static final String POLICY_NUMBER = "123";
    }

    public static class PageURLs {
        public static final String BREAKDOWN_OPTIONS = "breakdownOptions.xhtml";
        public static final String CARD_DETAILS = "cardInformation.xhtml";
        public static final String DIRECT_DEBIT = "directDebitInformation.xhtml";
        public static final String MORE_DETAILS_ABOUT_YOUR_COVER = "moreDetailsAboutYourCover.xhtml";
        public static final String PAYMENT_CONFIRMATION = "paymentConfirmation.xhtml";
        public static final String PAYMENT_OPTIONS = "paymentOptions.xhtml";
        public static final String QUOTE_DETAILS = "quoteDetails.xhtml";
        public static final String YOUR_JOINT_POLICY_HOLDER = "yourJointPolicyholder.xhtml";
        public static final String YOUR_QUOTE = "yourQuote.xhtml";
    }
}
