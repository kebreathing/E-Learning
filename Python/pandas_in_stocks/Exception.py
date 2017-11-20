
class EmptyParametersError(Exception):
    def __init__(self, empty_param):
        self.empty_param = empty_param

    def __str__(self):
        return "Parameter {%s} must not be empty!" % (self.empty_param)

