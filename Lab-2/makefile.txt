define compile 
	javac $(1).java
endef

define run 
	java $(1) < $(2)
endef

program: $(MAIN).class
	$(call run, $(MAIN), $(IN_FILE))

$(MAIN).class: 
	$(call compile, $(MAIN))
