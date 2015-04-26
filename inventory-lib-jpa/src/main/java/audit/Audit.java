package audit;

/**
 * Created by Ugo on 26/04/2015.
 */
public class Audit {

    private static AuditChangeContext auditChangeContext;

    public static AuditChangeContext getAuditChangeContext() {
        if (auditChangeContext == null) {
            return new WebRequestAuditChangeContext();
        } else {
            return auditChangeContext;
        }
    }

    public static void setAuditChangeContext(
            AuditChangeContext auditChangeContext) {
        Audit.auditChangeContext = auditChangeContext;
    }
}
