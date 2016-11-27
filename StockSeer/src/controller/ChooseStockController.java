package controller;

import persistence.StockUtility;
import view.ChooseStockPane;
import view.LeagueCreationPane;
import view.StockChartPane;
import view.renderModel.AvailableStockModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by aqv on 11/24/2016.
 */
public class ChooseStockController implements ActionListener {
    LeagueCreationPane leagueCreationPane;
    
    public ChooseStockController(LeagueCreationPane leagueCreationPane) {
        this.leagueCreationPane = leagueCreationPane;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        ArrayList<String> stocks = new ArrayList<>();
        
        switch (command) {
            case LeagueCreationPane.BTN_CHOOSE_STOCK: {
                ChooseStockPane chooseStockPane = ChooseStockPane.showChooseStockPane();
                chooseStockPane.registerController(e1 -> {
                    String command1 = e1.getActionCommand();
                    
                    switch (command1) {
                        case ChooseStockPane.BTN_ACCEPT: {
                            if (stocks.size() == 0) {
                                System.err.println("WARNING::Stocks array is null");
                            } else {
                                stocks.stream().forEach(System.out::println);
                                leagueCreationPane.setStocks(stocks.stream().toArray(String[]::new));
                            }
                            leagueCreationPane.setBtnCreateEnabled(true);
                            chooseStockPane.setVisible(false);
                            break;
                        }
                        case ChooseStockPane.BTN_REROLL: {
                            System.out.println("ACTION::Reroll");
                            String[] temp = StockUtility.getStocksForLeague(leagueCreationPane.getDifficulty(),
                                    leagueCreationPane.getCapacity());
                            Arrays.stream(temp).forEach(stocks::add);
                            
                            stocks.stream().forEach(System.out::println);
                            
                            AvailableStockModel availableStockModel = new AvailableStockModel();
                            availableStockModel.setData(temp);
                            chooseStockPane.setAvailStockModel(availableStockModel);
                            chooseStockPane.setBtnAcceptEnabled(true);
                            break;
                        }
                        case ChooseStockPane.BTN_STOCK_INFO: {
                            StockChartPane.show(chooseStockPane.getSelectedStock());
                            
                            break;
                        }
                        default:
                            break;
                    }
                });
                
                break;
            }
            default:
                break;
        }
    }
}
