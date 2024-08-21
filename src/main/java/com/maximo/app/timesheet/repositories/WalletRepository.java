package com.maximo.app.timesheet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maximo.app.timesheet.models.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Integer>{

}
