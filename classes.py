from functools import reduce


class OfficeEquipment:
    # в dimensions передавать str в формате 10*20*30
    # в color передавать True если уст-во цветное и False если черно-белое
    def __init__(self, model: str, dimensions: str, color: bool, paper_format: str):
        self.dimensions = dimensions
        self.model = model
        self.color = color
        self.paper_format = paper_format

    def __str__(self):
        return str(self.__dict__)


class Printer(OfficeEquipment):
    def __init__(self, model: str, dimensions: str, color: bool, paper_format: str, pr_technology: str):
        super().__init__(model, dimensions, color, paper_format)
        self.pr_tech = pr_technology

    def __str__(self):
        return str(self.__dict__)


class Scanner(OfficeEquipment):
    def __init__(self, model: str, dimensions: str, color: bool, paper_format: str, scanning_type: str):
        super().__init__(model, dimensions, color, paper_format)
        self.scan_type = scanning_type

    def __str__(self):
        return str(self.__dict__)


class Copier(OfficeEquipment):
    def __init__(self, model: str, dimensions: str, color: bool, paper_format: str, copy_type: str, copy_speed: int):
        super().__init__(model, dimensions, color, paper_format)
        self.copy_type = copy_type
        self.copy_speed = copy_speed

    def __str__(self):
        return str(self.__dict__)


class Warehouse:
    def __init__(self, location: str, size: float):
        self.location = location
        self.size = size
        self.free_place = self.size
        self.register_book = {}

    def __str__(self):
        return str(self.__dict__)

    def add_to_warehouse(self, equipment: OfficeEquipment, quantity: int):
        equipment_size = reduce((lambda x, y: x * y), list(map(float, equipment.dimensions.split("*"))))
        if self.free_place - (equipment_size * quantity) >= 0:
            self.free_place -= equipment_size
            class_name = str(type(equipment))[str(type(equipment)).find('.') + 1: -2]
            if self.register_book.get(class_name):
                if self.register_book[class_name].get(equipment.model):
                    self.register_book[class_name][equipment.model] += quantity
                else:
                    self.register_book[class_name][equipment.model] = quantity
            else:
                self.register_book[class_name] = {equipment.model: quantity}
            print(f'free place: {self.free_place}')
        else:
            print(f'There is no free place. Equipment too big!\n\tfree place: {self.free_place}\n\t'
                  f'equipment size: {equipment_size} x {quantity} = {equipment_size * quantity}')


if __name__ == '__main__':
    s = Scanner('XZ150', '10*10*10', True, "A4", "laser")
    s1 = Scanner('XZ150', '10*10*10', True, "A4", "laser")
    s2 = Scanner('SZ150', '10*10*10', True, "A4", "laser")

    p = Printer('pr50', '10*50*10.5', True, "A4", "laser")

    st = Warehouse('Minsk', 10000)

    st.add_to_warehouse(s, 1)
    st.add_to_warehouse(p, 1)
    st.add_to_warehouse(s1, 1)
    st.add_to_warehouse(s2, 1)

    print(st.register_book)