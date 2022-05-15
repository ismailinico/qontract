package de.nicoismaili.qontract.data.contract;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import de.nicoismaili.qontract.data.contract.pojo.Contract;

public class ContractRepository {
    private final ContractDAO contractDAO;
    private final LiveData<List<Contract>> allContracts;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public ContractRepository(Application application) {
        ContractRoomDatabase db = ContractRoomDatabase.getDatabase(application);
        contractDAO = db.contractDAO();
        allContracts = contractDAO.getAllContractsMinSortedByDate();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Contract>> getAllContracts() {
        return allContracts;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Contract contract) {
        ContractRoomDatabase.databaseWriteExecutor.execute(() -> contractDAO.insertContract(contract));
    }

    public void delete(Contract contract) {
        ContractRoomDatabase.databaseWriteExecutor.execute(() -> contractDAO.deleteContract(contract));
    }

    public void delete(List<Contract> contracts) {
        ContractRoomDatabase.databaseWriteExecutor.execute(() -> contractDAO.deleteContracts(contracts));
    }

    public void update(Contract contract) {
        ContractRoomDatabase.databaseWriteExecutor.execute(() -> contractDAO.updateContract(contract));
    }

    public LiveData<Contract> getContractById(int id) {
        return contractDAO.getContractById(id);
    }

    public LiveData<List<Contract>> getAllContractsByQuery(String query) {
        return contractDAO.getAllContractsByQueryMinSortedByDate(query);
    }

}
