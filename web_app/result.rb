module Result
  class Money
    def initialize(value)
      @value = value
    end

    def content
      "El precio es #{value} dólares"
    end

    def value
      '%.2f' % @value
    end
  end

  class StateTaxRate
    def initialize(options = {})
      @value = options[:tax_rate]
      @state = options[:name]
    end

    def content
      "La tasa de impuesto en #{@state} es #{value}% por ciento."
    end

    def value
      '%.2f' % @value
    end
  end

  class PriceWithStateTaxRate
    def initialize(options = {})
      @value = options[:price]
      @state = options[:state]
    end

    def content
      "El precio con la tasa de impuesto en #{@state} es #{value} dólares"
    end

    def value
      '%.2f' % @value
    end
  end
end
