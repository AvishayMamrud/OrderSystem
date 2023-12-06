package test;

import static org.junit.jupiter.api.Assertions.*;

import main.Permissions.OperationAccess;
import main.Utilities.Operation;
import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationAccessTest {
    private OperationAccess oa;
    @Before
    public void setUp() {
        oa = new OperationAccess();
    }

    @Test
    public void checkAccessForStore() {
        assertFalse(oa.checkAccess(1, Operation.ORDER_PLACEMENT));
        assertFalse(oa.checkAccess(2, Operation.ORDER_PLACEMENT));
    }

    @Test
    public void grantPermissionForStore() {
        assertFalse(oa.checkAccess(1, Operation.ORDER_PLACEMENT));
        oa.grantPermission(1, Operation.ORDER_PLACEMENT);
        assertTrue(oa.checkAccess(1, Operation.ORDER_PLACEMENT));
        assertFalse(oa.checkAccess(2, Operation.ORDER_PLACEMENT));
    }

    @Test
    public void denyPermissionForStore() {
        assertFalse(oa.checkAccess(1, Operation.ORDER_PLACEMENT));
        assertFalse(oa.denyPermission(1, Operation.ORDER_PLACEMENT));
        oa.grantPermission(1, Operation.ORDER_PLACEMENT);
        assertTrue(oa.denyPermission(1, Operation.ORDER_PLACEMENT));
        assertFalse(oa.checkAccess(1, Operation.ORDER_PLACEMENT));
    }

    @Test
    public void grantPermissionForStore_Exceptions() {
        assertThrows(IllegalArgumentException.class, () -> oa.grantPermission(1, Operation.STORES_MANAGEMENT));
        assertThrows(IllegalArgumentException.class, () -> oa.grantPermission(1, Operation.ORDERS_MANAGEMENT));
        assertThrows(IllegalArgumentException.class, () -> oa.grantPermission(1, Operation.PERMISSION_MANAGEMENT));
        assertThrows(IllegalArgumentException.class, () -> oa.grantPermission(1, Operation.CATALOG_MANAGEMENT));
        assertDoesNotThrow(() -> oa.grantPermission(1, Operation.PERMISSION_DELEGATION));
        assertDoesNotThrow(() -> oa.grantPermission(1, Operation.ORDER_PLACEMENT));
    }

    @Test
    public void testGrantPermissionForAdmin() {
        assertFalse(oa.checkAccess(Operation.PERMISSION_MANAGEMENT));
        oa.grantPermission(Operation.PERMISSION_MANAGEMENT);
        assertTrue(oa.checkAccess(Operation.PERMISSION_MANAGEMENT));
        assertFalse(oa.checkAccess(Operation.CATALOG_MANAGEMENT));
    }

    @Test
    public void testDenyPermissionForAdmin() {
        assertFalse(oa.checkAccess(Operation.PERMISSION_MANAGEMENT));
        assertFalse(oa.denyPermission(Operation.PERMISSION_MANAGEMENT));
        oa.grantPermission(Operation.PERMISSION_MANAGEMENT);
        assertTrue(oa.denyPermission(Operation.PERMISSION_MANAGEMENT));
        assertFalse(oa.checkAccess(Operation.PERMISSION_MANAGEMENT));
    }

    @Test
    public void grantPermissionForAdmin_Exceptions() {
        assertDoesNotThrow(() -> oa.grantPermission(Operation.STORES_MANAGEMENT));
        assertDoesNotThrow(() -> oa.grantPermission(Operation.ORDERS_MANAGEMENT));
        assertDoesNotThrow(() -> oa.grantPermission(Operation.PERMISSION_MANAGEMENT));
        assertDoesNotThrow(() -> oa.grantPermission(Operation.CATALOG_MANAGEMENT));
        assertThrows(IllegalArgumentException.class, () -> oa.grantPermission(Operation.PERMISSION_DELEGATION));
        assertThrows(IllegalArgumentException.class, () -> oa.grantPermission(Operation.ORDER_PLACEMENT));
    }

    @Test
    public void testCheckAccessForStore() {
        Map<Integer, List<Operation>> ops = new HashMap<>();
        List<Operation> opList = new ArrayList<>();
        opList.add(Operation.ORDER_PLACEMENT);
        ops.put(1, opList);
        oa = new OperationAccess(ops);
        assertTrue(oa.checkAccess(1, Operation.ORDER_PLACEMENT));
        assertFalse(oa.checkAccess(2, Operation.ORDER_PLACEMENT));
        assertFalse(oa.checkAccess(1, Operation.PERMISSION_DELEGATION));
        assertFalse(oa.checkAccess(1, Operation.STORES_MANAGEMENT));
    }

    @Test
    public void testCheckAccessForAdmin() {
        Map<Integer, List<Operation>> ops = new HashMap<>();
        List<Operation> opList = new ArrayList<>();
        opList.add(Operation.ORDERS_MANAGEMENT);
        ops.put(-1, opList);
        oa = new OperationAccess(ops);
        assertTrue(oa.checkAccess(Operation.ORDERS_MANAGEMENT));
        assertFalse(oa.checkAccess(Operation.STORES_MANAGEMENT));
        assertFalse(oa.checkAccess(Operation.PERMISSION_DELEGATION));
    }
}