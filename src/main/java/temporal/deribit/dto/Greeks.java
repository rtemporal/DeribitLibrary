package temporal.deribit.dto;

import java.io.Serializable;

public record Greeks
(
	Float	delta,
	Float	gamma,
	Float	rho,
	Float	theta,
	Float	vega
)
implements Serializable {
}