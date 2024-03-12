SUMMARY = "EVerest basecamp image"

IMAGE_FEATURES += "splash package-management ssh-server-dropbear"

LICENSE = "MIT"

inherit core-image

CORE_IMAGE_EXTRA_INSTALL = " \
	kernel-modules \
	htop \
	everest-core \
	node-red \
	everest-service \
	nodejs \
	nodejs-npm \
	openjdk-jre \
	mosquitto \
	tzdata \
	"

