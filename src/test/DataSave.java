import main.*
public class DataSave {
    public static void main(String[] args) {
        Seller seller1 = new Seller('Jason Wang', '3652768777', '1357', '210 spadina ave' 'Soda Treat');
        Seller seller2 = new Seller('Lucas Liu', '4899277216', '9999', '15 Yonge st', 'Cocktail Bazaar (alcohol)');
        Seller seller3 = new Seller('Allen', '6478916276', '0411', '100 Spadina ave', 'Fountain Drinks');
        Seller seller4 = new Seller('William Liu', '6473222922', '250250', '25 Wellesley st W', 'Drinksify');
        Seller seller5 = new Seller('Amanda', '5257688765', '289987', '957 Bay st', 'Junction Fizzy');
        Drink drink1a = new Drink('Cherry Vanilla Soda', 8.12, 'A soda juice with cherry vanilla flavour',
                'cherry juice, sugar, vanilla, soda', 125, 2022-09-31, 2023-09-31, 1);
        Drink drink1b = new Drink('Lemon Soda', 6.99, 'A soda drink with lemon flavour', 'lemon, soda, salt, sugar, water',
                125, 2022-12-01, 2023-12-01, 0.7);
        Drink drink1c = new Drink('Orange Juice Soda', 6.34, 'A soda drink with orange flavour', 'orange juice, sugar, soda, ginger',
                125, 2022-08-03, 2023-11-03, 1);
        Drink drink1d = new Drink('Masala Soda', 15.99, 'A refreshing Indian summer drink', 'mint leaves, ginger, lime juice, sugar, masala, water',
                375, 2022-09-01, 2023-02-01, 1);
        Drink drink1f = new Drink('Cream Soda', 7.1, 'A sweet soft soda drink flavoured with vanilla', 'sugar, water, vanilla, soda',
                125, 2022-02-18, 2022-08-18, 0.9);
        Drink drin1g = new Drink('Pineapple Soda', 4.8, 'A soda drink with Pineapple flavour', 'pineapple, water, sugar, lemon juice, soda',
                125, 2022-11-17, 2023-11-17, 0.8);
        Drink drink2a = new Drink('Aqua Velva', 14.5, 'An alcoholic cocktail known as American first after shave', 'wheat, alcohol, vodka, gin, blue curacao, syrup, lemon juice, soda water',
                50, 2022-03-11, 2023-03-11, 1);
        Drink drink2b = new Drink('Dirty Martini', 45.25, 'An alcoholic cocktail for olive lovers', 'wheat, alcohol, gin, dry vermouth, olive brine',
                375, 2022-08-01, 2023-02-01, 0.9);
        Drink drink2c = new Drink('Lillet Cocktail', 28.88, 'An alcoholic cocktail features the popular fortified wine', 'wheat, alcohol, lillet blanc, gin, tonic water'.
                375, 2022-11-12, 2023-05-12, 0.9);
        Drink drink2d = new Drink('Salty Dog Cocktail', 65.99, 'A classic alcoholic cocktail that can be made with vodka or gin', 'wheat, alcohol, gin, grapefruit juice, salt, syrup, lime',
                500, 2022-11-01, 2023-11-01, 1);
        Drink drink2e = new Drink('Blue Lagoon Cocktail', 49.28, 'An alcoholic cocktail with the bright colour and citrusy flavour', 'wheat, alcohol, vodka, blue curacao, lemon juice, syrup',
                500, 2022-10-10, 2023-07-10, 0.8);
    }
}