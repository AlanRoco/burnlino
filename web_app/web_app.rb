class WebApp
  def initialize(hexagon)
    @hex = hexagon
  end

  def echo_value(value)
    @hex.echo_value(value.to_i)
  end

  def get_tax_rate_for_state(name)
    @hex.get_tax_rate_for_state(name)
  end

  def price_with_tax_rate(value, state)
    @hex.calculate_price_with_tax_rate(value.to_i, state)
  end
end
