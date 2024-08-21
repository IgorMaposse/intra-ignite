package com.maximo.app.timesheet.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.maximo.app.timesheet.models.Project;
import com.maximo.app.timesheet.models.Wallet;
import com.maximo.app.timesheet.repositories.ProjectRepository;
import com.maximo.app.timesheet.repositories.WalletRepository;
import com.maximo.app.timesheet.services.ProjectService;
import com.maximo.app.timesheet.services.WalletService;

@Service
public class WalletServiceImpl implements WalletService{

	@Autowired
	private WalletRepository walletRepository;
	
	private Wallet existingWallet;
	


	@Override
	public List<Wallet> getAllWallets() {
		// TODO Auto-generated method stub
		return walletRepository.findAll();
	}

	@Override
	public void saveWallet(Wallet wallet) {
		// TODO Auto-generated method stub
		walletRepository.save(wallet);
	}

	@Override
	public void deleteWallet(Integer id) {
		// TODO Auto-generated method stub
		walletRepository.deleteById(id);
	}

	@Override
	public Wallet getWalletById(Integer id) {
		// TODO Auto-generated method stub
		return walletRepository.getById(id);
	}

	@Override
	public Wallet updateWalletDetails(Integer id, Wallet wallet) {
		// TODO Auto-generated method stub
		 existingWallet=getWalletById(id);
		// existingWallet.setName(project.getName());
		 //existingWallet.setId(project.getId());
		 

		
		return existingWallet;
	}

}
