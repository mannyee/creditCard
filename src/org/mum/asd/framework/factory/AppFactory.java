package org.mum.asd.framework.factory;

import java.util.HashMap;
import java.util.Iterator;

import org.mum.asd.framework.enums.Types;

public class AppFactory {
	public static HashMap<Enum, AbstractFactory> hashMap = new HashMap<>();

	static {
		hashMap.put(Types.PARTY, new PartyFactory());
		hashMap.put(Types.ACCOUNT, new AccountFactory());
	}

	public static AbstractFactory getFactory(Enum type) {
		Iterator it = hashMap.keySet().iterator();

		while (it.hasNext()) {
			System.out.println("item: " + it.next());
		}

		System.out.println("type: " + type);
		System.out.println("hashMap.get(type): " + hashMap.get(type));
		System.out.println("____________________");
		return hashMap.get(type);
	}

	public static void addAbstractFactory(Enum e, AbstractFactory factory) {
		hashMap.put(e, factory);
	}
}
