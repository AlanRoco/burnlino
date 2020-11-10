require 'json'

class Store
  include ForGettingTaxRates

  def initialize
    contents = read()
    @states = JSON.load(contents)
  end

  def tax_rate_for_state(name)
    @states[name]
  end

private
  def read
    File.read(File.expand_path(File.join(File.dirname(__FILE__), "./", "taxRates.json")))
  end
end
