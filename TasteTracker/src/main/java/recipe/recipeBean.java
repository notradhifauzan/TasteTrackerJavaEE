package recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class recipeBean {
	private int recipeID;
	private int inventorID;
	private String name;
	private String subject;
	private String description;
	private String steps;
	private String category;
	private String calories;
	private String imgAddress;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getInventorID() {
		return inventorID;
	}

	public void setInventorID(int inventorID) {
		this.inventorID = inventorID;
	}

	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCalories() {
		return calories;
	}

	public void setCalories(String calories) {
		this.calories = calories;
	}

	public String getImgAddress() {
		return imgAddress;
	}

	public void setImgAddress(String imgAddress) {
		this.imgAddress = imgAddress;
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "recipeBean [recipeID=" + recipeID + ", name=" + name + ", subject=" + subject + ", description="
				+ description + ", imgAddress=" + imgAddress + "]";
	}

	public recipeBean getRandomRecipe() {
		List<recipeBean> list = new ArrayList();

		recipeBean bean = new recipeBean();
		bean.setName("pizza wagyu");
		bean.setSubject("pizza wagyu kayu api");
		bean.setCategory("italian pizza");
		bean.setCalories("11,500");
		bean.setDescription("1. dough\n2. bread\n3. yeast\n4. sauce\n5. wagyu beef A5 marble");
		bean.setSteps("1. Start with a crust. ...\r\n" + "2. Add a sauce. ...\r\n" + "3. Add some veggies, such as:\r\n"
				+ "4. Try some fruit on your pizza, such as:\r\n" + "5. Add some protein, such as:\r\n"
				+ "6. Add cheese. ...\r\n" + "7. Bake your creation in a hot oven (450 F or above). ...\r\n"
				+ "8. Whole-wheat Pizza Crust.");

		list.add(bean);

		recipeBean bean1 = new recipeBean();
		bean1.setName("Spaghetti Carbonara");
		bean1.setSubject("Classic Italian Pasta Dish");
		bean1.setCategory("Italian");
		bean1.setCalories("800");
		bean1.setDescription("1. Cook spaghetti.\n2. Mix eggs, cheese, and pepper.\n3. Combine with cooked pasta.");
		bean1.setSteps(
				"1. Boil water and cook spaghetti.\n2. In a bowl, mix eggs, cheese, and pepper.\n3. Combine with cooked pasta.");

		list.add(bean1);

		recipeBean bean2 = new recipeBean();
		bean2.setName("Chicken Teriyaki");
		bean2.setSubject("Japanese Chicken Dish");
		bean2.setCategory("Japanese");
		bean2.setCalories("1200");
		bean2.setDescription("1. Marinate chicken in teriyaki sauce.\n2. Grill or pan-fry until cooked.");
		bean2.setSteps(
				"1. Marinate chicken in teriyaki sauce for 30 minutes.\n2. Grill or pan-fry until fully cooked.");

		list.add(bean2);

		recipeBean bean3 = new recipeBean();
		bean3.setName("Mushroom Risotto");
		bean3.setSubject("Creamy Italian Rice Dish");
		bean3.setCategory("Italian");
		bean3.setCalories("900");
		bean3.setDescription(
				"1. Sauté mushrooms and onions.\n2. Cook rice in broth.\n3. Combine with mushrooms and cheese.");
		bean3.setSteps(
				"1. Sauté mushrooms and onions in butter.\n2. Cook Arborio rice in chicken broth.\n3. Combine with mushrooms and Parmesan cheese.");

		list.add(bean3);

		recipeBean bean4 = new recipeBean();
		bean4.setName("Shrimp Tacos");
		bean4.setSubject("Mexican Seafood Tacos");
		bean4.setCategory("Mexican");
		bean4.setCalories("700");
		bean4.setDescription(
				"1. Marinate shrimp in spices.\n2. Grill or sauté shrimp.\n3. Assemble tacos with toppings.");
		bean4.setSteps(
				"1. Marinate shrimp in cumin, chili powder, and garlic.\n2. Grill or sauté shrimp until pink.\n3. Assemble tacos with lettuce, salsa, and sour cream.");

		list.add(bean4);

		recipeBean bean5 = new recipeBean();
		bean5.setName("Vegetarian Stir-Fry");
		bean5.setSubject("Healthy Vegetable Stir-Fry");
		bean5.setCategory("Asian");
		bean5.setCalories("600");
		bean5.setDescription(
				"1. Stir-fry mixed vegetables.\n2. Add tofu or soy protein.\n3. Season with soy sauce and ginger.");
		bean5.setSteps(
				"1. Stir-fry a mix of broccoli, bell peppers, and snap peas.\n2. Add tofu or soy protein.\n3. Season with soy sauce and ginger.");

		list.add(bean5);

		recipeBean bean6 = new recipeBean();
		bean6.setName("Grilled Salmon");
		bean6.setSubject("Simple Grilled Salmon");
		bean6.setCategory("Seafood");
		bean6.setCalories("850");
		bean6.setDescription("1. Marinate salmon in lemon and herbs.\n2. Grill until fish flakes easily.");
		bean6.setSteps(
				"1. Marinate salmon fillets in lemon juice, olive oil, and herbs.\n2. Grill until the fish flakes easily with a fork.");

		list.add(bean6);

		recipeBean bean7 = new recipeBean();
		bean7.setName("Quinoa Salad");
		bean7.setSubject("Healthy Quinoa and Vegetable Salad");
		bean7.setCategory("Salad");
		bean7.setCalories("500");
		bean7.setDescription("1. Cook quinoa and let it cool.\n2. Mix with chopped vegetables and feta cheese.");
		bean7.setSteps(
				"1. Cook quinoa according to package instructions and let it cool.\n2. Mix with chopped cucumber, tomato, red onion, and feta cheese.");

		list.add(bean7);

		recipeBean bean8 = new recipeBean();
		bean8.setName("Beef Stir-Fry");
		bean8.setSubject("Quick and Easy Beef Stir-Fry");
		bean8.setCategory("Asian");
		bean8.setCalories("950");
		bean8.setDescription(
				"1. Slice beef thinly.\n2. Stir-fry with vegetables in a wok.\n3. Season with soy sauce and sesame oil.");
		bean8.setSteps(
				"1. Slice beef thinly against the grain.\n2. Stir-fry with broccoli, bell peppers, and carrots in a wok.\n3. Season with soy sauce and sesame oil.");

		list.add(bean8);

		recipeBean bean9 = new recipeBean();
		bean9.setName("Caprese Salad");
		bean9.setSubject("Classic Italian Tomato and Mozzarella Salad");
		bean9.setCategory("Salad");
		bean9.setCalories("550");
		bean9.setDescription("1. Slice tomatoes and mozzarella.\n2. Arrange on a plate with fresh basil leaves.");
		bean9.setSteps(
				"1. Slice ripe tomatoes and fresh mozzarella.\n2. Arrange on a plate with fresh basil leaves.\n3. Drizzle with balsamic glaze.");

		list.add(bean9);

		recipeBean bean10 = new recipeBean();
		bean10.setName("Pasta Primavera");
		bean10.setSubject("Vegetarian Pasta with Spring Vegetables");
		bean10.setCategory("Italian");
		bean10.setCalories("700");
		bean10.setDescription("1. Cook pasta.\n2. Sauté mixed vegetables.\n3. Toss with pasta and Parmesan cheese.");
		bean10.setSteps(
				"1. Cook your favorite pasta until al dente.\n2. Sauté a mix of spring vegetables like asparagus, peas, and cherry tomatoes.\n3. Toss the vegetables with the cooked pasta and sprinkle with grated Parmesan cheese.");

		list.add(bean10);

		recipeBean bean11 = new recipeBean();
		bean11.setName("Chicken Alfredo Pasta");
		bean11.setSubject("Creamy Chicken and Pasta Dish");
		bean11.setCategory("Italian");
		bean11.setCalories("1000");
		bean11.setDescription(
				"1. Cook fettuccine pasta.\n2. Sauté chicken in Alfredo sauce.\n3. Combine with cooked pasta.");
		bean11.setSteps(
				"1. Boil water and cook fettuccine pasta.\n2. Sauté chicken in Alfredo sauce.\n3. Combine with cooked pasta.");

		list.add(bean11);

		recipeBean bean12 = new recipeBean();
		bean12.setName("Garden Vegetable Soup");
		bean12.setSubject("Homemade Vegetable Soup");
		bean12.setCategory("Soup");
		bean12.setCalories("400");
		bean12.setDescription(
				"1. Chop and sauté vegetables.\n2. Add broth and simmer.\n3. Season with herbs and spices.");
		bean12.setSteps(
				"1. Chop carrots, celery, and onions; sauté in olive oil.\n2. Add vegetable broth and simmer until vegetables are tender.\n3. Season with herbs like thyme and rosemary.");

		list.add(bean12);

		recipeBean bean13 = new recipeBean();
		bean13.setName("Tofu Stir-Fry");
		bean13.setSubject("Vegetarian Tofu Stir-Fry");
		bean13.setCategory("Asian");
		bean13.setCalories("600");
		bean13.setDescription(
				"1. Press and cube tofu.\n2. Stir-fry with vegetables in soy sauce.\n3. Serve over rice.");
		bean13.setSteps(
				"1. Press tofu to remove excess water; cube into bite-sized pieces.\n2. Stir-fry tofu with broccoli, bell peppers, and snap peas in soy sauce.\n3. Serve over cooked rice.");

		list.add(bean13);

		recipeBean bean14 = new recipeBean();
		bean14.setName("Berry Smoothie Bowl");
		bean14.setSubject("Healthy Breakfast Smoothie Bowl");
		bean14.setCategory("Breakfast");
		bean14.setCalories("350");
		bean14.setDescription(
				"1. Blend mixed berries and yogurt.\n2. Pour into a bowl and top with granola and fresh fruits.");
		bean14.setSteps(
				"1. Blend mixed berries with Greek yogurt until smooth.\n2. Pour into a bowl and top with granola, sliced banana, and berries.");

		list.add(bean14);

		recipeBean bean15 = new recipeBean();
		bean15.setName("Eggplant Parmesan");
		bean15.setSubject("Baked Eggplant with Marinara Sauce");
		bean15.setCategory("Italian");
		bean15.setCalories("900");
		bean15.setDescription(
				"1. Slice and bread eggplant.\n2. Bake with marinara sauce and cheese.\n3. Serve over pasta.");
		bean15.setSteps(
				"1. Slice eggplant; bread slices in a mixture of breadcrumbs and Parmesan cheese.\n2. Bake with marinara sauce and mozzarella cheese until bubbly.\n3. Serve over cooked pasta.");

		list.add(bean15);

		Random random = new Random();
		int randomIndex = random.nextInt(list.size());
		return list.get(randomIndex);
	}

}
