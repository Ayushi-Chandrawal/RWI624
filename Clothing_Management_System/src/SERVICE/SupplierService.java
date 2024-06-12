package SERVICE;

import DAO.SupplierDao;
import MODEL.Order;
import MODEL.Supplier;

import java.sql.SQLException;
import java.util.List;

public class SupplierService {
    private SupplierDao supplierDao;

    public SupplierService() {
        supplierDao = new SupplierDao();
    }

    public void addSupplier(Supplier supplier) throws SQLException {
        supplierDao.addSupplier(supplier);
    }

    public Supplier getSupplierById(int id) throws SQLException {
        return supplierDao.getSupplierID(id);
    }

    public List<Supplier> getAllSupplier() throws SQLException {
        return supplierDao.getAllSuppliers();
    }

    public void updateSupplier(Supplier supplier) throws SQLException {
        supplierDao.updateSupplier(supplier);
    }

    public void deleteSupplier(int id) throws SQLException {
        supplierDao.deleteSupplier(id);
    }
}
