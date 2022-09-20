package UseCases.DomainEventHandler.Aeronave;

import Event.VentaCreada;
import core.ConfirmedDomainEvent;
import core.DomainEvent;
import core.IntegrationEvent;
import Fourteam.massTransit.IPublishEndpoint;
import Fourteam.mediator.Notification;
import Fourteam.mediator.NotificationHandler;

public class PublishIntegrationEventWhenVentaCreadoHandler
    implements NotificationHandler<ConfirmedDomainEvent<VentaCreada>> {

  private IPublishEndpoint publishEndpoint;

  public PublishIntegrationEventWhenVentaCreadoHandler(IPublishEndpoint publishEndpoint) {
    this.publishEndpoint = publishEndpoint;
  }

  @Override
  public void handle(Notification notification) {
    ConfirmedDomainEvent event = (ConfirmedDomainEvent) notification;
    VentaCreada eve = (VentaCreada) event.DomainEvent;
    IntegrationEvents.VentaCreado evento = new IntegrationEvents.VentaCreado();
    // evento.Key = eve.Key;
    evento.setNombre(eve.nombre);
    evento.setApellido(eve.apellido);
    evento.setDni(eve.dni);
    evento.setKeyVuelo(eve.keyVuelo);


    this.publishEndpoint.Publish(evento);
  }
}
