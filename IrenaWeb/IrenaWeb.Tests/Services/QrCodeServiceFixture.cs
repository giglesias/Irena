namespace IrenaWeb.Tests.Helpers
{
    using IrenaWeb.Models;
    using IrenaWeb.Services;

    using Microsoft.VisualStudio.TestTools.UnitTesting;

    [TestClass]
    public class QrCodeServiceFixture
    {
        [TestMethod]
        public void GenerateRelayQrCode_ShouldEncodeMedicalHistoryInAImgHtmlTag()
        {
            // Arrange
            var medicalHistory = new HistoriaClinica();
            var qrCodeService = new QrCodeService();

            // Act
            var actual = qrCodeService.GenerateRelayQrCode(medicalHistory);

            // Arrange
            Assert.IsNotNull(actual);
            Assert.IsTrue(actual.ToString().Contains("<img"));
        }
    }
}
