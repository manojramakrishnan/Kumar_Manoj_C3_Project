import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	private String name;
	private String location;
	public LocalTime openingTime;
	public LocalTime closingTime;
	private List<Item> menu = new ArrayList<Item>();

	public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
		this.name = name;
		this.location = location;
		this.openingTime = openingTime;
		this.closingTime = closingTime;

		// default menu items
		this.menu.add(new Item("chickenBiriyani", 120));
		this.menu.add(new Item("tomato rice", 80));
		this.menu.add(new Item("veg pulav", 50));
	}

	public boolean isRestaurantOpen() {
		LocalTime currentTime = LocalTime.now();
		System.out.println("closingTime"+closingTime);
		System.out.println("openingTime"+openingTime);
		int restuarantStillOpen = currentTime.compareTo(closingTime);
		int restuarantAlreadyOpen = currentTime.compareTo(openingTime);
		if (restuarantStillOpen < 0 && restuarantAlreadyOpen >= 0) {
			
			return true;
		}
		return false;
	}

	public LocalTime getCurrentTime() {
		return LocalTime.now();
	}

	public List<Item> getMenu() {

		return this.menu;

	}

	public LocalTime getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(LocalTime openingTime) {
		this.openingTime = openingTime;
	}

	public LocalTime getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(LocalTime closingTime) {
		this.closingTime = closingTime;
	}

	private Item findItemByName(String itemName) {
		for (Item item : menu) {
			if (item.getName().equals(itemName))
				return item;
		}
		return null;
	}

	public void addToMenu(String name, int price) {
		Item newItem = new Item(name, price);
		menu.add(newItem);
	}

	public void removeFromMenu(String itemName) throws itemNotFoundException {

		Item itemToBeRemoved = findItemByName(itemName);
		if (itemToBeRemoved == null)
			throw new itemNotFoundException(itemName);

		menu.remove(itemToBeRemoved);
	}

	public void displayDetails() {
		System.out.println("Restaurant:" + name + "\n" + "Location:" + location + "\n" + "Opening time:" + openingTime
				+ "\n" + "Closing time:" + closingTime + "\n" + "Menu:" + "\n" + getMenu());

	}

	public String getName() {
		return name;
	}

}
