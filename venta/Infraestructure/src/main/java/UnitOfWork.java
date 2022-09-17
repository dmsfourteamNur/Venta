import Context.IWriteDbContext;
import Repositories.IUnitOfWork;
import core.ConfirmedDomainEvent;
import core.DomainEvent;
import Fourteam.db.Exception.DataBaseException;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.Mediator;
import java.util.List;

public class UnitOfWork implements IUnitOfWork {

  private IWriteDbContext _context;
  private Mediator _mediator;

  public UnitOfWork(IWriteDbContext context, Mediator mediator) {
    _context = context;
    _mediator = mediator;
  }

  @Override
  public void commit() throws Exception {
    List<Object> events = _context.getDomainEvents();
    for (Object domainEvent : events) {
      DomainEvent event = (DomainEvent) domainEvent;
      try {
        _mediator.notify(event);
      } catch (Exception e) {

      }
    }
    try {
      _context.Commit();
    } catch (DataBaseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    for (Object domainEvent : events) {
      DomainEvent event = (DomainEvent) domainEvent;
      try {
        _mediator.notify(MakeGeneryc(event));
      } catch (Exception e) {
      }
    }
  }

  public <T> ConfirmedDomainEvent<T> MakeGeneryc(T o) {
    return new ConfirmedDomainEvent<T>(o);
  }
}
