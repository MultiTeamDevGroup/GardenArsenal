//package multiteam.gardenarsenal.mixin;
//
//import multiteam.gardenarsenal.recipes.SkinUpgradeRecipe;
//import multiteam.gardenarsenal.registries.GardenArsenalRecipeTypes;
//import net.minecraft.world.Container;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.ContainerLevelAccess;
//import net.minecraft.world.inventory.ItemCombinerMenu;
//import net.minecraft.world.inventory.LegacySmithingMenu;
//import net.minecraft.world.inventory.MenuType;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.Level;
//import org.jetbrains.annotations.Nullable;
//import org.spongepowered.asm.mixin.Final;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//import java.util.List;
//
//@Mixin(LegacySmithingMenu.class)
//public abstract class LegacySmithingMenuMixin extends ItemCombinerMenu {
//    @Shadow @Final private Level level;
//
//    public LegacySmithingMenuMixin(@Nullable MenuType<?> menuType, int i, Inventory inventory, ContainerLevelAccess containerLevelAccess) {
//        super(menuType, i, inventory, containerLevelAccess);
//    }
//
//
//    @Nullable
//    private SkinUpgradeRecipe selectedSkinRecipe;
//    private List<SkinUpgradeRecipe> skinRecipes;
//
//    @Inject(method = "<init>(ILnet/minecraft/world/entity/player/Inventory;Lnet/minecraft/world/inventory/ContainerLevelAccess;)V", at = @At("RETURN"))
//    private void ga$contrusctor(int i, Inventory inventory, ContainerLevelAccess containerLevelAccess, CallbackInfo ci) {
//        this.skinRecipes = this.level
//                .getRecipeManager()
//                .<Container, SkinUpgradeRecipe>getAllRecipesFor(GardenArsenalRecipeTypes.SKIN_UPGRADE.get())
//                .stream()
//                .toList();
//    }
//
//    @Inject(method = "mayPickup", at = @At("RETURN"), cancellable = true)
//    private void ga$mayPickup(Player player, boolean bl, CallbackInfoReturnable<Boolean> cir) {
//        if (this.selectedSkinRecipe != null && this.selectedSkinRecipe.matches(this.inputSlots, this.level)) {
//            cir.setReturnValue(true);
//        }
//    }
//
//    @Inject(method = "createResult", at = @At("RETURN"))
//    private void ga$createResult(CallbackInfo ci) {
//        List<SkinUpgradeRecipe> list = this.level
//                .getRecipeManager()
//                .getRecipesFor(GardenArsenalRecipeTypes.SKIN_UPGRADE.get(), this.inputSlots, this.level)
//                .stream()
//                .toList();
//        if (!list.isEmpty()) {
//            SkinUpgradeRecipe legacyUpgradeRecipe = list.get(0);
//            ItemStack itemStack = legacyUpgradeRecipe.assemble(this.inputSlots, this.level.registryAccess());
//            if (itemStack.isItemEnabled(this.level.enabledFeatures())) {
//                this.selectedSkinRecipe = legacyUpgradeRecipe;
//                this.resultSlots.setRecipeUsed(legacyUpgradeRecipe);
//                this.resultSlots.setItem(0, itemStack);
//            }
//        }
//    }
//
//    @Inject(method = "shouldQuickMoveToAdditionalSlot", at = @At("RETURN"), cancellable = true)
//    private void ga$shouldQuickMoveToAdditionalSlot(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
//        if (this.skinRecipes.stream().anyMatch(legacyUpgradeRecipe -> legacyUpgradeRecipe.isAdditionIngredient(itemStack))) {
//            cir.setReturnValue(true);
//        }
//    }
//}
