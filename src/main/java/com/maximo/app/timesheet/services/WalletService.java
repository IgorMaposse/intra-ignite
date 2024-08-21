package com.maximo.app.timesheet.services;

import java.util.List;


import com.maximo.app.timesheet.models.Project;
import com.maximo.app.timesheet.models.Wallet;

public interface WalletService {

	

	List<Wallet> getAllWallets();
	
	void saveWallet(Wallet wallet);
	
	void deleteWallet(Integer id);
	
	public Wallet getWalletById(Integer id);
	
	Wallet updateWalletDetails(Integer id, Wallet wallet);

}
