package good.patterns.Order;

import good.patterns.Order.Model.User;

public class ProductEmailInformationService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Sending confirmation email to " + user.getEmail());
    }
}
