package scale;

import adapter.ProxyAutomobile;

public class EditHelper extends ProxyAutomobile {
	
	//private boolean available = true; // indicating there nothing to get.

	public synchronized void updateOptionSetNameSync(String [] auto) {
		System.out.printf("Entering synchronized method \n");


		try {
			updateOptionSetName(auto[0], auto[1], auto[2]);
			// updateOptionSetName(key, oldOptionSetName, newOptionSetName);
			System.out.printf("Option set name changed in synchronized method \n");
		} catch (Exception e) {
			System.out.printf("Option set name to be changed, not found\n");
		}
	}

	public void updateOptionSetNameUnsync(String[] auto) {
		System.out.printf("Entering unsynchronized method \n");

		try {
			updateOptionSetName(auto[0], auto[1], auto[2]);
			// updateOptionSetName(key, oldOptionSetName, newOptionSetName);
			System.out.printf("Option set name changed in unsynchronized method\n");
		} catch (Exception e) {
			System.out.printf("Option set name to be changed, not found\n");
		}
	}
	
	
/*
	public synchronized void updateOptionNameSync(String[] auto) {
		System.out.printf("Entering synchronized method \n");

		while (available == false) {
			try {
				System.out.printf("Get Sleeping \n");
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.printf("Get done sleeping \n");
			}
		}

		try {
			updateOptionName(auto[0], auto[1], auto[2], auto[3]);
			// updateOptionSetName(key, oldOptionSetName, newOptionSetName);
			System.out.printf("Option name changed in synchronized method\n");
		} catch (Exception e) {
			System.out.printf("Option name to be changed, not found\n");
		}
	}

	public void updateOptionNameUnsync(String[] auto) {
		System.out.printf("Entering unsynchronized method \n");

		while (available == false) {
			try {
				System.out.printf("Get Sleeping \n");
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.printf("Get done sleeping \n");
			}
		}

		try {
			updateOptionName(auto[0], auto[1], auto[2], auto[3]);
			// updateOptionSetName(key, oldOptionSetName, newOptionSetName);
			System.out.printf("Option name changed in unsynchronized method\n");
		} catch (Exception e) {
			System.out.printf("Option name to be changed, not found\n");
		}
	}

	public synchronized void updateOptionPriceSync(String[] auto) {
		System.out.printf("Entering synchronized method \n");

		while (available == false) {
			try {
				System.out.printf("Get Sleeping \n");
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.printf("Get done sleeping \n");
			}
		}

		try {
			updateOptionPrice(auto[0], auto[1], auto[2], Float.parseFloat(auto[3]));
			System.out.printf("Option price changed in synchronized method\n");
		} catch (Exception e) {
			System.out.printf("Option price to be changed, not found\n");
		}
	}

	public void updateOptionPriceUnsync(String[] auto) {
		System.out.printf("Entering unsynchronized method \n");

		while (available == false) {
			try {
				System.out.printf("Get Sleeping \n");
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.printf("Get done sleeping \n");
			}
		}

		try {
			updateOptionPrice(auto[0], auto[1], auto[2], Float.parseFloat(auto[3]));
			// updateOptionSetName(key, oldOptionSetName, newOptionSetName);
			System.out.printf("Option price changed in unsynchronized method \n");
		} catch (Exception e) {
			System.out.printf("Option price to be changed, not found\n");
		}
	}
*/
	
	/*
	// waiting on each other.
	int contents = 55;

	public synchronized int get() {
		System.out.println("Entering Get method " + contents);

		while (available == false) {
			try {
				// wait for Producer to put value
				System.out.println("Get Waiting " + contents);
				wait();
			} catch (InterruptedException e) {
				System.out.println("Get done waiting " + contents);
			}
		}
		available = false;
		// notify Producer that value has been retrieved
		System.out.println("Get Notifyall " + contents);
		notifyAll();
		System.out.println("Get Done! " + contents);
		return contents;
	}

	public synchronized void put(int value) {
		System.out.println("Entering Post method " + contents);

		while (available == true) {
			try {
				// wait for Consumer to get value
				System.out.println("Put Waiting " + contents);
				wait();

			} catch (InterruptedException e) {
				System.out.println("Put done waiting " + contents);

			}
		}
		contents = value;
		available = true;
		// notify Consumer that value has been set
		System.out.println("Put added new value - notifyall " + contents);
		notifyAll();
		System.out.println("Put done " + contents);
	}*/
}
