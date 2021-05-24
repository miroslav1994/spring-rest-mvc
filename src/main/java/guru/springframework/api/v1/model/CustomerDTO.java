package guru.springframework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    @JsonProperty("customer_url")
    private String customerUrl;

    public CustomerDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getCustomerUrl() {
        return this.customerUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("customer_url")
    public void setCustomerUrl(String customerUrl) {
        this.customerUrl = customerUrl;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CustomerDTO)) return false;
        final CustomerDTO other = (CustomerDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        final Object this$customerUrl = this.getCustomerUrl();
        final Object other$customerUrl = other.getCustomerUrl();
        if (this$customerUrl == null ? other$customerUrl != null : !this$customerUrl.equals(other$customerUrl))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CustomerDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $customerUrl = this.getCustomerUrl();
        result = result * PRIME + ($customerUrl == null ? 43 : $customerUrl.hashCode());
        return result;
    }

    public String toString() {
        return "CustomerDTO(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", customerUrl=" + this.getCustomerUrl() + ")";
    }
}
