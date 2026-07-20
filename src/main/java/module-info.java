module temporal.deribit
{
    requires transitive java.rmi;
	requires java.net.http;
	requires transitive javafx.base;
	requires tools.jackson.databind;
	exports temporal.deribit.dto;
	exports temporal.deribit.exception;
	exports temporal.deribit.library;
	exports temporal.deribit.notifications;
	exports temporal.deribit.params;
}
